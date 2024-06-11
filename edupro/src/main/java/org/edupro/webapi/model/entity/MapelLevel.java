/**
 * 
 */
package org.edupro.webapi.model.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Master data mapel per level
 * 
 * @author Awiyanto Ajisasongko
 *
 * Nov 30, 2023
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "T_MAPEL_LEVEL")
@AttributeOverrides({
	@AttributeOverride(name = "createdAt", column = @Column(name="MAPLVLCRD")),
	@AttributeOverride(name = "createdBy", column = @Column(name="MAPLVLCRUID")),
	@AttributeOverride(name = "updatedAt", column = @Column(name="MAPLVLUPD")),
	@AttributeOverride(name = "updatedBy", column = @Column(name="MAPLVLUPUID"))
})
public class MapelLevel extends BaseEntity {
	
	@EmbeddedId
	private MapelLevelId id;
	
	
	/**
	 * 0 = semua sesi (ganjil dan genap)
	 * 1 = semester ganjil saja
	 * 2 = semester genap saja
	 */
	@Column(name = "SAURUT")
	private Integer noUruSesiAkademik;
	
	@Column(name = "MAPLVLKKM")
	private double nilaiKKM;
}
