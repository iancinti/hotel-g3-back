package com.g3.hotel_g3_back.attraction.adapter.out;

import com.g3.hotel_g3_back.attraction.adapter.in.AttractionControllerAdapter;
import com.g3.hotel_g3_back.attraction.application.port.out.CreateAttractionRepository;
import com.g3.hotel_g3_back.attraction.domain.Attraction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;

@Component
public class CreateAttractionJdbcAdapter implements CreateAttractionRepository {

    private final Logger log = LoggerFactory.getLogger(AttractionControllerAdapter.class);
    private final JdbcTemplate jdbcTemplate;

    private static final String INSERT_ATTRACTION_SQL = "INSERT INTO Attraction (name, description) VALUES (?, ?)";
    private static final String INSERT_IMAGE_SQL = "INSERT INTO Image (id_room, url_image, id_attraction) VALUES (?, ?, ?)";

    @Autowired
    public CreateAttractionJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void execute(Attraction attraction) {
        log.info("Intentando crear una atracción");
        KeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            jdbcTemplate.update(
                    connection -> {
                        PreparedStatement ps = connection.prepareStatement(INSERT_ATTRACTION_SQL, new String[] { "id_attraction" });
                        ps.setString(1, attraction.getTitle());
                        ps.setString(2, attraction.getDescription());
                        return ps;
                    },
                    keyHolder
            );

            Number attractionId = keyHolder.getKey();
            log.info("Atracción creada con ID: {}", attractionId);

            jdbcTemplate.update(INSERT_IMAGE_SQL, 1, attraction.getUrlImage(), attractionId);
            log.info("Imagen asociada a la atracción creada.");
        } catch (DataAccessException e) {
            log.error("Error al crear atracción: {}", e.getMessage());
            log.error("Error al crear atracción: {}", e.getCause().getMessage());
        }
    }
}
