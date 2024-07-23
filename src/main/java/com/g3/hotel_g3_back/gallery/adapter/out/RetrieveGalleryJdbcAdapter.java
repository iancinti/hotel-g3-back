package com.g3.hotel_g3_back.gallery.adapter.out;

import com.g3.hotel_g3_back.gallery.application.port.out.RetrieveGalleryRepository;
import com.g3.hotel_g3_back.gallery.domain.Gallery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class RetrieveGalleryJdbcAdapter implements RetrieveGalleryRepository {

    private final JdbcTemplate jdbcTemplate;

    public RetrieveGalleryJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Gallery> execute() {
        String query = "SELECT id_image, id_room, id_attraction, url_image FROM image";
        return jdbcTemplate.query(query, new RowMapper<Gallery>() {
            @Override
            public Gallery mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer idRoom = rs.getObject("id_room") != null ? rs.getInt("id_room") : null;
                Integer idAttraction = rs.getObject("id_attraction") != null ? rs.getInt("id_attraction") : null;
                String urlImage = rs.getString("url_image");
                Integer idImage = rs.getInt("id_image");

                return new Gallery(
                        idImage,
                        idRoom,
                        idAttraction,
                        new ArrayList<>(Arrays.asList(urlImage))
                );
            }
        });
    }
}
