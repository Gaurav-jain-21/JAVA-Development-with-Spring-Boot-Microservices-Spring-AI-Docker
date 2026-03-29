package com.gaurav.firstproject.repo;

import com.gaurav.firstproject.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlienRepo {

    private final JdbcTemplate template;

    @Autowired
    public AlienRepo(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Alien alien) {
        String sql = "insert into alien(id, name, tech) values (?, ?, ?)";
        template.update(sql, alien.getId(), alien.getName(), alien.getTech());
    }

    public List<Alien> findAll() {
        String sql = "select * from alien";

        return template.query(sql, (rs, rowNum) -> {
            Alien alien = new Alien();
            alien.setId(rs.getInt("id"));
            alien.setName(rs.getString("name"));
            alien.setTech(rs.getString("tech"));
            return alien;
        });
    }
}