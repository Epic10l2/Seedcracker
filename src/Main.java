import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StructureChecker {
    private List<int[]> coordinates;
    private long salt;

    public StructureChecker(long salt) {
        this.coordinates = new ArrayList<>();
        this.salt = salt;
    }

    public void addCoordinates(int chunkX, int chunkZ) {
        coordinates.add(new int[]{chunkX, chunkZ});
    }

    public boolean canGenerateAtAll(long halfSeed, boolean isShip) {
        for (int[] coord : coordinates) {
            if (!canGenerateInTheFirstPlace(halfSeed, coord[0], coord[1], isShip)) {
                return false;
            }
        }
        return true;
    }

    public boolean canActuallyGenerate(long fullSeed, boolean isShip) {
        for (int[] coord : coordinates) {
            if (!canReallyGenerate(fullSeed, coord[0], coord[1], isShip)) {
                return false;
            }
        }
        return true;
    }

    private boolean canGenerateInTheFirstPlace(long halfSeed, int chunkX, int chunkZ, boolean isShip) {
        int regX = isShip ? chunkX / 24 : chunkX >> 5;
        int regZ = isShip ? chunkZ / 24 : chunkZ >> 5;
        long mask = isShip ? 3 : 7;

        long newHalfSeed = ((halfSeed + regX * 341873128712L + regZ * 132897987541L + salt) ^ 25214903917L) & ((1L << 32) - 1);
        newHalfSeed = (newHalfSeed * 25214903917L + 11) & ((1L << 32) - 1);

        if (((newHalfSeed >> 17) & mask) == (chunkX & mask)) {
            newHalfSeed = (newHalfSeed * 25214903917L + 11) & ((1L << 32) - 1);
            return ((newHalfSeed >> 17) & mask) == (chunkZ & mask);
        }
        return false;
    }

    private boolean canReallyGenerate(long fullSeed, int chunkX, int chunkZ, boolean isShip) {
        int regX = isShip ? chunkX / 24 : chunkX >> 5;
        int regZ = isShip ? chunkZ / 24 : chunkZ >> 5;
        long mask = isShip ? 20 : 24;
        long coordMask = isShip ? 24 : 32;

        long newFullSeed = ((fullSeed + regX * 341873128712L + regZ * 132897987541L + salt) ^ 25214903917L) & ((1L << 48) - 1);
        newFullSeed = (newFullSeed * 25214903917L + 11) & ((1L << 48) - 1);

        if (((newFullSeed >> 17) % mask) == (((chunkX % coordMask)+coordMask)%coordMask)) {
            newFullSeed = (newFullSeed * 25214903917L + 11) & ((1L << 48) - 1);
            return ((((newFullSeed >> 17) % mask) + mask) % mask) == (((chunkZ % coordMask)+coordMask)%coordMask);
        }
        return false;
    }
}

public class Main {
    public static boolean printToFile = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = scanner.nextLine();

        File file = new File(filename);
        InputStream inputStream = null;

        try {
            inputStream = file.exists() ? new FileInputStream(file) : Main.class.getResourceAsStream("/" + filename);
            if (inputStream == null) {
                throw new IOException("File not found: " + filename);
            }
        } catch (IOException e) {
            System.out.println("Error opening file: " + e.getMessage());
            return;
        }

        List<Long> structureSeeds = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(inputStream)) {
            long pillarSeed = fileScanner.nextLong();
            long gateWay = fileScanner.nextLong();
            fileScanner.nextLine();

            StructureChecker desertTempleChecker = new StructureChecker(14357617L);
            StructureChecker jungleTempleChecker = new StructureChecker(14357619L);
            StructureChecker iglooChecker = new StructureChecker(14357618L);
            StructureChecker swampHutChecker = new StructureChecker(14357620L);
            StructureChecker outpostChecker = new StructureChecker(165745296);
            StructureChecker shipwreckChecker = new StructureChecker(165745295);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.equalsIgnoreCase("true") || line.equalsIgnoreCase("false")) {
                    boolean findStructureSeed = Boolean.parseBoolean(line);
                    line = fileScanner.nextLine().trim();
                    Main.printToFile = Boolean.parseBoolean(line);
                    if (pillarSeed == -1) {
                        crackSeedsWithoutPillars(desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, gateWay, findStructureSeed, structureSeeds);
                    } else {
                        crackSeeds(pillarSeed, gateWay, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, findStructureSeed, structureSeeds);
                    }
                    break;
                } else {
                    String[] parts = line.split("\\s+");
                    if (parts.length == 3) {
                        String structureType = parts[0].toLowerCase();
                        int chunkX = Integer.parseInt(parts[1]);
                        int chunkZ = Integer.parseInt(parts[2]);

                        switch (structureType) {
                            case "desert":
                                desertTempleChecker.addCoordinates(chunkX, chunkZ);
                                break;
                            case "jungle":
                                jungleTempleChecker.addCoordinates(chunkX, chunkZ);
                                break;
                            case "igloo":
                                iglooChecker.addCoordinates(chunkX, chunkZ);
                                break;
                            case "swamp":
                                swampHutChecker.addCoordinates(chunkX, chunkZ);
                                break;
                            case "outpost":
                                outpostChecker.addCoordinates(chunkX, chunkZ);
                                break;
                            case "ship":
                                shipwreckChecker.addCoordinates(chunkX, chunkZ);
                                break;
                            default:
                                System.out.println("Unknown structure type: " + structureType);
                        }
                    } else {
                        System.out.println("Invalid line format: " + line);
                    }
                }
            }
        }

        try (FileWriter writer = new FileWriter("structureseeds.txt")) {
            for (Long seed : structureSeeds) {
                if (printToFile) {
                    writer.write(seed + "\n");
                }
                System.out.println("Found valid structure seed: " + seed);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        Scanner closing = new Scanner(System.in);
        System.out.println("Press enter to close");
        String close = scanner.nextLine();
    }

    private static void crackSeeds(long pillarSeed, long gateWay, StructureChecker desertTempleChecker, StructureChecker jungleTempleChecker, StructureChecker iglooChecker, StructureChecker swampHutChecker, StructureChecker outpostChecker, StructureChecker shipwreckChecker, boolean findStructureSeed, List<Long> structureSeeds) {
        for (long lowerBits = 0; lowerBits < 65536; lowerBits++) {
            long partialRandomInternalState = (pillarSeed << 16) + lowerBits;
            long halfSeed = ((1540035429L * (1540035429L * partialRandomInternalState + 239479465L) + 239479465L) ^ 25214903917L) & 4294967295L;

            if (canGenerateAtAll(desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, halfSeed)) {
                if (gateWay != -1) {
                    long nextSeed = halfSeed ^ 25214903917L;
                    nextSeed = (nextSeed * 25214903917L + 11) & ((1L << 32) - 1);
                    if (((nextSeed >> 17) & 3) == (gateWay & 3)) {
                        processHalfSeed(desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, halfSeed, gateWay, findStructureSeed, structureSeeds);
                    }
                } else {
                    processHalfSeed(desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, halfSeed, gateWay, findStructureSeed, structureSeeds);
                }
            }
        }
    }

    private static void crackSeedsWithoutPillars(StructureChecker desertTempleChecker, StructureChecker jungleTempleChecker, StructureChecker iglooChecker, StructureChecker swampHutChecker, StructureChecker outpostChecker, StructureChecker shipwreckChecker, long gateWay, boolean findStructureSeed, List<Long> structureSeeds) {
        for (long lowerBits = 0; lowerBits < 4294967296L; lowerBits++) {
            long halfSeed = lowerBits;
            if (canGenerateAtAll(desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, halfSeed)) {
                processHalfSeed(desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, halfSeed, gateWay, findStructureSeed, structureSeeds);
            }
        }
    }

    private static void processHalfSeed(StructureChecker desertTempleChecker, StructureChecker jungleTempleChecker, StructureChecker iglooChecker, StructureChecker swampHutChecker, StructureChecker outpostChecker, StructureChecker shipwreckChecker, long halfSeed, long gateWay, boolean findStructureSeed, List<Long> structureSeeds) {
        System.out.println("Found halfSeed: " + halfSeed);
        if (findStructureSeed) {
            crackStructureSeed(desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, halfSeed, gateWay, structureSeeds);
        }
    }

    private static boolean canGenerateAtAll(StructureChecker desertTempleChecker, StructureChecker jungleTempleChecker, StructureChecker iglooChecker, StructureChecker swampHutChecker, StructureChecker outpostChecker, StructureChecker shipwreckChecker, long halfSeed) {
        return desertTempleChecker.canGenerateAtAll(halfSeed, false) &&
                jungleTempleChecker.canGenerateAtAll(halfSeed, false) &&
                iglooChecker.canGenerateAtAll(halfSeed, false) &&
                swampHutChecker.canGenerateAtAll(halfSeed, false) &&
                outpostChecker.canGenerateAtAll(halfSeed, false) &&
                shipwreckChecker.canGenerateAtAll(halfSeed, true);
    }

    private static void crackStructureSeed(StructureChecker desertTempleChecker, StructureChecker jungleTempleChecker, StructureChecker iglooChecker, StructureChecker swampHutChecker, StructureChecker outpostChecker, StructureChecker shipwreckChecker, long halfSeed, long gateWay, List<Long> structureSeeds) {
        for (long structureSeed = halfSeed; structureSeed < (1L << 48); structureSeed += (1L << 32)) {
            if (canActuallyGenerate(desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, structureSeed)) {
                long nextSeed = structureSeed ^ 25214903917L;
                nextSeed = (nextSeed * 25214903917L + 11) & ((1L << 48) - 1);
                if (((nextSeed >> 17) % 20) == gateWay || gateWay == -1) {
                    structureSeeds.add(structureSeed);
                }
            }
        }
    }

    private static boolean canActuallyGenerate(StructureChecker desertTempleChecker, StructureChecker jungleTempleChecker, StructureChecker iglooChecker, StructureChecker swampHutChecker, StructureChecker outpostChecker, StructureChecker shipwreckChecker, long structureSeed) {
        return desertTempleChecker.canActuallyGenerate(structureSeed, false) &&
                jungleTempleChecker.canActuallyGenerate(structureSeed, false) &&
                iglooChecker.canActuallyGenerate(structureSeed, false) &&
                swampHutChecker.canActuallyGenerate(structureSeed, false) &&
                outpostChecker.canActuallyGenerate(structureSeed, false) &&
                shipwreckChecker.canActuallyGenerate(structureSeed, true);
    }
}
