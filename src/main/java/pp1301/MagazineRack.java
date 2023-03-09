package pp1301;

public class MagazineRack {

    public static void main(String[] args){
        MagazineList rack = new MagazineList();

        rack.add(new Magazine("Fast Cars"));
        rack.add(new Magazine("Slow Cars"));
        rack.add(new Magazine("Honda Civics with Spoilers"));
        rack.add(new Magazine("Trucks that Scrape their Chassis on Speedbumps"));
        System.out.println(rack);
        rack.sort();
        System.out.println(rack);

        rack.insert(new Magazine("Time"));
        rack.insert(new Magazine("Woodworking Today"));
        rack.insert(new Magazine("Communications"));
        rack.insert(new Magazine("House and Garden"));
        rack.insert(new Magazine("GQ"));
        System.out.println(rack);
        rack.delete(2);
        System.out.println(rack);

        System.out.println(rack.search(new Magazine("Time")));




    }
}
