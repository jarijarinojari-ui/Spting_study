package com.global.hibernate.entity;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "MUSIC_DETAIL")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(
    name = "seq_music_detail_gen",
    sequenceName = "SEQ_MUSIC_DETAIL",
    schema = "MUSIC",
    allocationSize = 1
)
@ToString(exclude = "music")
public class MusicDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_music_detail_gen")
    @Column(name = "MUSIC_DETAIL_NO")
    private Long musicDetailNo;

    @Column(name = "RELEASE_COMP")
    private String releaseComp;

    @Column(name = "RELEASE_DATE")
    private LocalDate releaseDate;

    @Column(name = "CREATE_DATE")
    private LocalDate createDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MUSIC_NO")
    private Music music;
}