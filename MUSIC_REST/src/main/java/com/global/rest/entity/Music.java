package com.global.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "MUSIC", schema = "MUSIC")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "musicDetail")
public class Music extends BaseEntity {

    @Id
    @Column(name = "MUSIC_NO", nullable = false, precision = 8)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MUSIC_GEN")
    @SequenceGenerator(
            name           = "SEQ_MUSIC_GEN",
            sequenceName   = "MUSIC.SEQ_MUSIC",
            allocationSize = 1,
            initialValue   = 1
    )
    private Long musicNo;

    @Column(name = "TITLE", nullable = false, length = 200)
    private String title;

    @Column(name = "VOCAL", nullable = false, length = 200)
    private String vocal;

    @OneToOne(mappedBy = "music", fetch = FetchType.LAZY)
    private MusicDetail musicDetail;
}
