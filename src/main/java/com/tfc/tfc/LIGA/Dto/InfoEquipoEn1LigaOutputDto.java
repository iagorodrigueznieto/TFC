package com.tfc.tfc.LIGA.Dto;


import lombok.Data;

@Data
public class InfoEquipoEn1LigaOutputDto {

private Integer codEquipo;
private Integer codLiga;
private Integer puntos;
private Integer partidosJugados;
private Integer partidosGanados;
private Integer partidosPerdidos;
private Integer partidosEmpatados;
private Integer golesFavor;
private Integer golesContra;

}
