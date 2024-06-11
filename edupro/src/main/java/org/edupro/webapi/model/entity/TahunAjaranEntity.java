/**
 * 
 */
package org.edupro.webapi.model.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Awiyanto Ajisasongko
 *
 * Oct 7, 2023
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "T_TAHUNAJARAN")
@AttributeOverrides({
		@AttributeOverride(name = "createdAt", column = @Column(name="TACRD")),
		@AttributeOverride(name = "createdBy", column = @Column(name="TACRUID")),
		@AttributeOverride(name = "updatedAt", column = @Column(name="TAUPD")),
		@AttributeOverride(name = "updatedBy", column = @Column(name="TAUPUID")),
		@AttributeOverride(name = "status", column = @Column(name="TASTAT"))
})
public class TahunAjaranEntity extends BaseEntity {
	
	@Id
	@Column(name = "TAID", nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TAHUNAJARAN")
	@TableGenerator(name = "TAHUNAJARAN", table = "T_SEQUENCE", pkColumnName = "SEQ_NAME", pkColumnValue = "TAHUNAJARAN", valueColumnName = "SEQ_VAL", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	@Column(name = "TANM", length = 50, nullable = false)
	private String nama;
	
	@Column(name = "KURKD", length = 20, nullable = false)
	private String kodeKurikulum;
}
