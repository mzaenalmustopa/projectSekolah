/**
 * 
 */
package org.edupro.webapi.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Awiyanto Ajisasongko
 *
 * Nov 30, 2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class MapelLevelId implements Serializable {
	private static final long serialVersionUID = 1046652654729567284L;

	@Column(name = "LBGID", nullable = false)
	private Integer idLembaga;

	@Column(name = "LVLKD", length = 10, nullable = false)
	private String kodeLevel;

	@Column(name = "MAPELKD", length = 10, nullable = false)
	private String kodeMapel;
}
