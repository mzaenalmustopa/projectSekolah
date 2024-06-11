/**
 * 
 */
package org.edupro.webapi.model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Data peserta mata pelajaran per tahun ajaran dan semester
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
@Table(name = "T_SESI_AKADEMIK_MAPEL_PESERTA")
public class SesiAkademikMapelLevelPeserta extends BlankBaseEntity {
	private static final long serialVersionUID = -9042433341420102754L;
	@EmbeddedId
	private SesiAkademikMapelLevelPesertaId id;
	
	private double nilaiTugas;
	private double nilaiUTS;
	private double nilaiUAS;
	private double nilaiAkhir;
	private String catatan;
}
