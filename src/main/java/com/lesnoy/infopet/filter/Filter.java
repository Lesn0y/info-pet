package com.lesnoy.infopet.filter;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "filters", schema = "infopet")
public class Filter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "filter_name")
    @JsonProperty("filter")
    private String filterName;

    @Override
    public String toString() {
        return "Filter{" +
                "filterName='" + filterName + '\'' +
                '}';
    }
}
