package com.cg.organizationserver.service;

import com.cg.organizationserver.dto.OrganizationDto;

public interface OrganizationService {

	
	OrganizationDto saveOrganization(OrganizationDto organizationDto);
	
	OrganizationDto getByOrganizationByCode(String organizationCode);
}
