/**
 * 
 */
package org.edupro.webapi.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.edupro.webapi.constant.DataStatus;

/**
 * Level ini menunjukkan tingkatan kelas
 * Contoh level I, II, III, dst
 * 
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
@Table(name = "T_LEVEL")
public class LevelEntity extends BlankBaseEntity {
	private static final long serialVersionUID = -1692222214526057221L;

	@EmbeddedId
	private LevelId id;

	@Column(name = "LVLNM", length = 10, nullable = false)
	private String nama;
	
	@Default
	@Column(name = "LVLSTAT", length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private DataStatus status = DataStatus.AKTIF;
}
