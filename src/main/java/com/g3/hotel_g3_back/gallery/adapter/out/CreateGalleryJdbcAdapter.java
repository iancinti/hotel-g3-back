package com.g3.hotel_g3_back.gallery.adapter.out;

import com.g3.hotel_g3_back.gallery.application.port.out.CreateGalleryRepository;
import com.g3.hotel_g3_back.gallery.domain.Gallery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Component
public class CreateGalleryJdbcAdapter implements CreateGalleryRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String INSERT_IMAGE_SQL = "INSERT INTO image (id_room, url_image, id_attraction) VALUES (?, ?, ?)";

    public CreateGalleryJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void execute(Gallery gallery) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        Integer idRoom = gallery.getIdRoom() != null ? gallery.getIdRoom() : null;
        Integer idAttraction = gallery.getIdAttraction() != null ? gallery.getIdAttraction() : null;

        for (String url : gallery.getImageUrl()) {
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(
                        INSERT_IMAGE_SQL,
                        Statement.RETURN_GENERATED_KEYS
                );
                if (idRoom != null) {
                    ps.setInt(1, idRoom);
                } else {
                    ps.setNull(1, java.sql.Types.INTEGER);
                }
                ps.setString(2, url);
                if (idAttraction != null) {
                    ps.setInt(3, idAttraction);
                } else {
                    ps.setNull(3, java.sql.Types.INTEGER);
                }
                return ps;
            }, keyHolder);
        }

        System.out.println("Gallery created successfully");
    }
}