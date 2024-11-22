package br.com.start.meupet.partner.service;

import br.com.start.meupet.partner.dto.PartnerRequestDTO;
import br.com.start.meupet.common.service.EmailService;
import br.com.start.meupet.common.service.ServiceUtils;
import br.com.start.meupet.partner.repository.PartnerRepository;
import br.com.start.meupet.partner.dto.PartnerResponseDTO;
import br.com.start.meupet.partner.usecase.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PartnerService {

    private static final Logger log = LoggerFactory.getLogger(PartnerService.class);
    private final ListPartnersUseCase listPartnersUseCase;
    private final FindPartnerByIdUseCase findPartnerByIdUseCase;
    private final CreatePartnerUseCase createPartnerUseCase;
    private final UpdatePartnerUseCase updatePartnerUseCase;
    private final DeletePartnerUseCase deletePartnerUseCase;

    public PartnerService(
           ServiceUtils serviceUtils,
           ListPartnersUseCase listPartnersUseCase,
           FindPartnerByIdUseCase findPartnerByIdUseCase,
           CreatePartnerUseCase createPartnerUseCase,
           UpdatePartnerUseCase updatePartnerUseCase,
           DeletePartnerUseCase deletePartnerUseCase)
    {
        this.listPartnersUseCase = listPartnersUseCase;
        this.findPartnerByIdUseCase = findPartnerByIdUseCase;
        this.createPartnerUseCase = createPartnerUseCase;
        this.updatePartnerUseCase = updatePartnerUseCase;
        this.deletePartnerUseCase = deletePartnerUseCase;
    }

    public List<PartnerResponseDTO> listAll(int page, int pageSize) {
        return listPartnersUseCase.execute(page, pageSize);
    }

    public PartnerResponseDTO getPartnerById(UUID id) {
        return findPartnerByIdUseCase.execute(id);
    }

    public PartnerResponseDTO insert(PartnerRequestDTO partnerRequest) {
       return createPartnerUseCase.execute(partnerRequest);
    }

    public PartnerResponseDTO update(UUID id, PartnerRequestDTO newPartner) {
        return updatePartnerUseCase.execute(id, newPartner);
    }

    public void delete(UUID id) {
        deletePartnerUseCase.execute(id);
    }
}