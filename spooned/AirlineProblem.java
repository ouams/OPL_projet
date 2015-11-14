// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class AirlineProblem {
    public static void main(java.lang.String[] args) {
        java.util.Scanner scannerToReadAirlines = null;
        try {
            scannerToReadAirlines = new java.util.Scanner(new java.io.File("airlines.txt"));
        } catch (java.io.IOException e) {
            java.lang.System.out.println("Could not connect to file airlines.txt.");
            java.lang.System.exit(0);
        }
        if (scannerToReadAirlines != null) {
            java.util.ArrayList<AirlineProblem.Airline> airlinesPartnersNetwork = new java.util.ArrayList<AirlineProblem.Airline>();
            AirlineProblem.Airline newAirline;
            java.lang.String lineFromFile;
            java.lang.String[] airlineNames;
            while (scannerToReadAirlines.hasNext()) {
                lineFromFile = scannerToReadAirlines.nextLine();
                airlineNames = lineFromFile.split(",");
                newAirline = new AirlineProblem.Airline(airlineNames);
                airlinesPartnersNetwork.add(newAirline);
            }
            java.lang.System.out.println(airlinesPartnersNetwork);
            java.util.Scanner keyboard = new java.util.Scanner(java.lang.System.in);
            java.lang.System.out.print("Enter airline miles are on: ");
            java.lang.String start = keyboard.nextLine();
            java.lang.System.out.print("Enter goal airline: ");
            java.lang.String goal = keyboard.nextLine();
            java.util.ArrayList<java.lang.String> pathForMiles = new java.util.ArrayList<java.lang.String>();
            java.util.ArrayList<java.lang.String> airlinesVisited = new java.util.ArrayList<java.lang.String>();
            if (AirlineProblem.canRedeem(start, goal, pathForMiles, airlinesVisited, airlinesPartnersNetwork))
                java.lang.System.out.println(("Path to redeem miles: " + pathForMiles));
            else
                java.lang.System.out.println((((("Cannot convert miles from " + start) + " to ") + goal) + "."));
            
        } 
    }

    private static boolean canRedeem(java.lang.String current, java.lang.String goal, java.util.ArrayList<java.lang.String> pathForMiles, java.util.ArrayList<java.lang.String> airlinesVisited, java.util.ArrayList<AirlineProblem.Airline> network) {
        if (current.equals(goal)) {
            pathForMiles.add(current);
            return true;
        } else if (airlinesVisited.contains(current))
            return false;
        else {
            airlinesVisited.add(current);
            pathForMiles.add(current);
            int pos = -1;
            int index = 0;
            while ((pos == (-1)) && (index < (network.size()))) {
                if (network.get(index).getName().equals(current))
                    pos = index;
                
                index++;
            }
            if (pos == (-1))
                return false;
            
            index = 0;
            java.lang.String[] partners = network.get(pos).getPartners();
            boolean foundPath = false;
            while ((!foundPath) && (index < (partners.length))) {
                foundPath = AirlineProblem.canRedeem(partners[index], goal, pathForMiles, airlinesVisited, network);
                index++;
            }
            if (!foundPath)
                pathForMiles.remove(((pathForMiles.size()) - 1));
            
            return foundPath;
        }
    }

    private static class Airline {
        private java.lang.String name;

        private java.util.ArrayList<java.lang.String> partners;

        public Airline(java.lang.String[] data) {
            assert (data != null) && ((data.length) > 0) : "Failed precondition";
            name = data[0];
            partners = new java.util.ArrayList<java.lang.String>();
            for (int i = 1 ; i < (data.length) ; i++)
                partners.add(data[i]);
        }

        public java.lang.String[] getPartners() {
            return partners.toArray(new java.lang.String[partners.size()]);
        }

        public boolean isPartner(java.lang.String name) {
            return partners.contains(name);
        }

        public java.lang.String getName() {
            return name;
        }

        public java.lang.String toString() {
            return ((name) + ", partners: ") + (partners);
        }
    }
}

