package com.global.hibernate.entity;

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
@Table(name = "MUSIC")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(
    name = "seq_music_gen",
    sequenceName = "SEQ_MUSIC",
    schema = "MUSIC",
    allocationSize = 1
)
@ToString(exclude = "musicDetail")
public class Music extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_music_gen")
    @Column(name = "MUSIC_NO")
    private Long musicNo;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "VOCAL")
    private String vocal;

    @OneToOne(mappedBy = "music", fetch = FetchType.LAZY)
    @JoinColumn(name = "MUSIC_NO")
    private MusicDetail musicDetail;    
}