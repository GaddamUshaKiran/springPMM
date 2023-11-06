package com.pmms.core;

import com.pmmss.core.College;

//Entity class
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "certificate_details")

public class Certificate{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

  private long id;
  private int year;
  private College college;

  public Certificate(long id, int year, College college) {
      this.id = id;
      this.year = year;
      this.college = college;
  }

  public long getId() {
      return id;
  }

  public void setId(long id) {
      this.id = id;
  }

  public int getYear() {
      return year;
  }

  public void setYear(int year) {
      this.year = year;
  }

  public College getCollege() {
      return college;
  }

  public void setCollege(College college) {
      this.college = college;
  }

	@Override
	public String toString() {
		return "Certificate [id=" + id + ", year=" + year + "]";
	}
}




