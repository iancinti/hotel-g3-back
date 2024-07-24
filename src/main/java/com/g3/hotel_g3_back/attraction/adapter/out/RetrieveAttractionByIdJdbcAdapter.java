package com.g3.hotel_g3_back.attraction.adapter.out;

import com.g3.hotel_g3_back.attraction.application.port.out.RetrieveAttractionByIdRepository;
import com.g3.hotel_g3_back.attraction.domain.Attraction;
import com.g3.hotel_g3_back.share.exception.GenericException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RetrieveAttractionByIdJdbcAdapter implements RetrieveAttractionByIdRepository {

    private final Logger log = LoggerFactory.getLogger(RetrieveAttractionByIdJdbcAdapter.class);
    private final JdbcTemplate jdbcTemplate;

    private static final String SELECT_ATTRACTION_BY_ID_SQL = "SELECT id_attraction, name, description FROM attraction WHERE id_attraction = ?";

    @Autowired
    public RetrieveAttractionByIdJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Attraction execute(Integer id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_ATTRACTION_BY_ID_SQL, new Object[]{id}, new AttractionRowMapper());
        } catch (DataAccessException e) {
            log.error("Error al recuperar la atracción por ID: {}", e.getMessage());
            throw new GenericException("Error al acceder a la base de datos al intentar recuperar la atracción", e);
        }
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

