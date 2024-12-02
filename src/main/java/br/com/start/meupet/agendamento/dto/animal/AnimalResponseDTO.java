package br.com.start.meupet.agendamento.dto.animal;

import br.com.start.meupet.agendamento.enums.AnimalPorte;
import br.com.start.meupet.agendamento.enums.AnimalSexo;
import br.com.start.meupet.agendamento.enums.AnimalType;

public record AnimalResponseDTO(Long id, String name, AnimalPorte porte, AnimalType type, AnimalSexo sexo) {
}