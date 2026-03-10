package com.global.rest.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "MUSIC_DETAIL", schema = "MUSIC")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "music")
public class MusicDetail extends BaseEntity {

    @Id
    @Column(name = "MUSIC_DETAIL_NO", nullable = false, precision = 8)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MUSIC_DETAIL_GEN")
    @SequenceGenerator(
            name           = "SEQ_MUSIC_DETAIL_GEN",
            sequenceName   = "MUSIC.SEQ_MUSIC_DETAIL",
            allocationSize = 1,
            initialValue   = 1
    )
    private Long musicDetailNo;

    @Column(name = "RELEASE_COMP", nullable = false, length = 200)
    private String releaseComp;

    @Column(name = "RELEASE_DATE")
    private LocalDate releaseDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MUSIC_NO", referencedColumnName = "MUSIC_NO")
    private Music music;
}
