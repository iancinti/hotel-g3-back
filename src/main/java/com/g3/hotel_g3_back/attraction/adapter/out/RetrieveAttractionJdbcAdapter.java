package com.g3.hotel_g3_back.attraction.adapter.out;

import com.g3.hotel_g3_back.attraction.application.port.out.RetrieveAttractionRepository;
import com.g3.hotel_g3_back.attraction.domain.Attraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class RetrieveAttractionJdbcAdapter implements RetrieveAttractionRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String SELECT_ATTRACTIONS_SQL = "SELECT id_attraction, name, description FROM attraction";

    @Autowired
    public RetrieveAttractionJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Attraction> execute() {
        return jdbcTemplate.query(SELECT_ATTRACTIONS_SQL, new AttractionRowMapper());
    }

    private static class AttractionRowMapper implements RowMapper<Attraction> {
        @Override
        public Attraction mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("id_attraction");
            String name = rs.getString("name");
            String description = rs.getString("description");
            return new Attraction(id, name, description, null);
        }
    }
}

