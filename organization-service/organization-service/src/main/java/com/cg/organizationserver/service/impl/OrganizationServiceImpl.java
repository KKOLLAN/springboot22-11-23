package com.cg.organizationserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.organizationserver.dto.OrganizationDto;
import com.cg.organizationserver.entity.Organization;
import com.cg.organizationserver.mapper.OrganizationMapper;
import com.cg.organizationserver.repository.OrganizationRepository;
import com.cg.organizationserver.service.OrganizationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	OrganizationRepository organizationRepository;
	
	
	@Override
	public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

		Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
		
		Organization savedOrganization = organizationRepository.save(organization);
		
		OrganizationDto saveOrganizationDto =  OrganizationMapper.mapToOrganizationDto(savedOrganization);
		

		return saveOrganizationDto;
	}


	@Override
	public OrganizationDto getByOrganizationByCode(String organizationCode) {
		
		Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
		
		OrganizationDto organizationDto = OrganizationMapper.mapToOrganizationDto(organization);
		return organizationDto;
	}

}
