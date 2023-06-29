package com.nt.model;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
//@SQLDelete(sql = "DELETE FROM TOURIST WHERE STATUS=?")
//@Where(clause = "status<>deleted")
public class Tourist {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "TSEQ1",initialValue = 1001,allocationSize = 100)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.AUTO)
	private Integer tid;
    @NonNull
	private String tname;
    @NonNull
	private String tcity;
    @NonNull
    private String packageType;
    @NonNull
	private Double budget;
}
