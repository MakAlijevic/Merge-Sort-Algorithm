package ibu.edu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Korisnik\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED\\IP-COUNTRY-REGION-CITY-SHUFFLED.csv";
        String RecursiveMergeSortPath = "C:\\Users\\Korisnik\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED\\RecursiveMergeSort IPs.csv";
        String BottomUpMergeSortPath = "C:\\Users\\Korisnik\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED\\BottomUpMergeSort IPs.csv";

        File file = new File(path);
        File newFileRecursiveMerge = new File(RecursiveMergeSortPath);
        File newFileBottomUpMerge = new File(BottomUpMergeSortPath);


        Scanner input = new Scanner(file);

        FileWriter recursiveMergeFileWriter = new FileWriter(newFileRecursiveMerge);
        FileWriter bottomUpMergeFileWriter = new FileWriter(newFileBottomUpMerge);


        String[] ips;
        IPAddress[] ipAddressesRecursiveMerge = new IPAddress[50];
        IPAddress[] ipAddressesBottomUpMerge = new IPAddress[50];

        int i = 0;
        while (input.hasNextLine() && i < 50) {

            String data = input.nextLine();
            data = data.replace("\"", "");
            ips = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            long ipFrom = Long.parseLong(ips[0]);
            long ipTo = Long.parseLong(ips[1]);
            ipAddressesRecursiveMerge[i] = new IPAddress(ipFrom, ipTo, ips[2], ips[3], ips[4], ips[5]);
            ipAddressesBottomUpMerge[i] = new IPAddress(ipFrom, ipTo, ips[2], ips[3], ips[4], ips[5]);
            i++;

        }
        input.close();

        //Recursive Merge sort
        long start = System.currentTimeMillis();

        RecursiveMergeSort.sort(ipAddressesRecursiveMerge);

        for (int a = 0; a < ipAddressesRecursiveMerge.length; a++) {
            recursiveMergeFileWriter.write("\"" + ipAddressesRecursiveMerge[a].ipFrom + "\"," + "\"" + ipAddressesRecursiveMerge[a].ipTo + "\"," + "\"" + ipAddressesRecursiveMerge[a].countryCode + "\"," + "\"" + ipAddressesRecursiveMerge[a].countryName + "\"," + "\"" + ipAddressesRecursiveMerge[a].regionName + "\"," + "\"" + ipAddressesRecursiveMerge[a].cityName + "\n");
        }
        recursiveMergeFileWriter.close();
        System.out.println("Recursive Merge sort completed! Done in " + (System.currentTimeMillis() - start) + " ms");

        //Bottom-Up Merge sort
        start = System.currentTimeMillis();

        BottomUpMergeSort.sort(ipAddressesBottomUpMerge);

        for (int b = 0; b < ipAddressesBottomUpMerge.length; b++) {
            bottomUpMergeFileWriter.write("\"" + ipAddressesBottomUpMerge[b].ipFrom + "\"," + "\"" + ipAddressesBottomUpMerge[b].ipTo + "\"," + "\"" + ipAddressesBottomUpMerge[b].countryCode + "\"," + "\"" + ipAddressesBottomUpMerge[b].countryName + "\"," + "\"" + ipAddressesBottomUpMerge[b].regionName + "\"," + "\"" + ipAddressesBottomUpMerge[b].cityName + "\n");
        }
        bottomUpMergeFileWriter.close();
        System.out.println("Bottom-up Merge sort completed! Done in " + (System.currentTimeMillis() - start) + " ms");
    }
}
