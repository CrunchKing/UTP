package zad1;

import sun.util.locale.LocaleUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.registry.LocateRegistry;
import java.util.*;

public class TravelData {

    private List<Record> data;

    public TravelData(File dataDir) {
        data = new ArrayList<>();

        Arrays.stream(Objects.requireNonNull(dataDir.listFiles())).forEach(file -> {
            try {
                Files.lines(Paths.get(file.getPath())).forEach(line -> {
                    String[] lineData = line.split("\t");

                    int i = 0;

                    Record record = new Record(
                            Locale.forLanguageTag(lineData[i++].replace("_", "-")),
                            lineData[i++],
                            lineData[i++],
                            lineData[i++],
                            lineData[i++],
                            lineData[i++],
                            lineData[i]
                    );

                    data.add(record);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    List<String> getOffersDescriptionsList(String loc, String dateFormat) {
        List<String> descList = new ArrayList<>();

        data.forEach(d -> {
            StringBuilder sb = new StringBuilder();

            String country = translateCountry(d.getCountryCode(),
                    Locale.forLanguageTag(loc.replace("_", "-")), d.getCountryName());
            sb.append(country).append(" ");
            sb.append(d.getDateFrom()).append(" ");
            sb.append(d.getDateTo()).append(" ");
            sb.append(d.getLocation()).append(" ");
            sb.append(d.getPrice()).append(" ");
            sb.append(d.getCurrency());

            descList.add(sb.toString());
        });

        return descList;
    }

    private String translateCountry(Locale inLocale, Locale outLocale, String countrName) {
        for (Locale l : Locale.getAvailableLocales()) {
            if (l.getDisplayCountry(inLocale).equals(countrName)) {
                return l.getDisplayCountry(outLocale);
            }
        }

        return null;
    }

    List<Record> getData() {
        return data;
    }
}
