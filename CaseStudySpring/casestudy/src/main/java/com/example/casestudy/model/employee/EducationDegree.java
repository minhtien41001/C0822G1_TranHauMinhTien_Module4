package com.example.casestudy.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EducationDegree {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  int id;

        private String name;

        @OneToMany(mappedBy = "educationDegree")
//    @JsonBackReference
        private Set<Employee> employees;

        public EducationDegree() {
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Set<Employee> getEmployees() {
                return employees;
        }

        public void setEmployees(Set<Employee> employees) {
                this.employees = employees;
        }
}