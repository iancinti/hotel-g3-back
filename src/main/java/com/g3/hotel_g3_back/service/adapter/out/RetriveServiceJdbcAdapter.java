package com.g3.hotel_g3_back.service.adapter.out;

import com.g3.hotel_g3_back.service.appliction.port.out.RetiveServiceQueryRepository;
import com.g3.hotel_g3_back.service.domain.Service;
import com.g3.hotel_g3_back.share.exception.GenericException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RetriveServiceJdbcAdapter implements RetiveServiceQueryRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL_SERVICES_SQL = "SELECT id, name, description, price FROM service";

    public RetriveServiceJdbcAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Service> execute() {
        try {
            return jdbcTemplate.query(SELECT_ALL_SERVICES_SQL, new ServiceRowMapper());
        } catch (DataAccessException e) {
            throw new GenericException("Error al recuperar los servicios", e);
        }
    }

    private static class ServiceRowMapper implements RowMapper<Service> {
        @Override
        public Service mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Service(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getDouble("price")
            );
        }
    }
}

