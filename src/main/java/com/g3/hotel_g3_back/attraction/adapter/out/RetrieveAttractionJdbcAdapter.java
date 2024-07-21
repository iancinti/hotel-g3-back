package com.g3.hotel_g3_back.attraction.adapter.out;

import com.g3.hotel_g3_back.attraction.application.port.out.RetrieveAttractionRepository;
import com.g3.hotel_g3_back.attraction.domain.Attraction;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RetrieveAttractionJdbcAdapter implements RetrieveAttractionRepository {
    @Override
    public List<Attraction> execute() {
        return Arrays.asList(
                new Attraction(1, "Jardin Japones", "Lorem ipsum dolor sit amet, consectetur " +
                        "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                        "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
                        "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit " +
                        "esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non " +
                        "proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
                new Attraction(2, "Planetario", "Lorem ipsum dolor sit amet, consectetur " +
                        "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                        "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
                        "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit " +
                        "esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non " +
                        "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
        );
    }
}
