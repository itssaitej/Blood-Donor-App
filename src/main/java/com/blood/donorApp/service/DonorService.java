package com.blood.donorApp.service;

import com.blood.donorApp.model.Donor;
import com.blood.donorApp.repository.DonorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class DonorService 
{
	@Autowired
	private final DonorRepository repo;

	public List<Donor> searchByCity(String city) 
	{
	    return repo.findByCityIgnoreCase(city);
    }

	public List<Donor> searchByCityAndBlood(String city, String bloodGroup) 
	{
	    return repo.findByCityIgnoreCaseAndBloodGroupIgnoreCase(city, bloodGroup);
    }

	public List<Donor> searchByArea(String area) 
	{
	    return repo.findByAreaIgnoreCase(area);
	}
	
    public DonorService(DonorRepository repo) 
    {
        this.repo = repo;
    }

    public Donor addDonor(Donor donor) 
    {
        return repo.save(donor);
    }

    public List<Donor> getAllDonors() 
    {
        return repo.findAll();
    }

    public List<Donor> searchByBloodGroup(String bloodGroup) 
    {
        return repo.findByBloodGroupIgnoreCaseAndAvailableTrue(bloodGroup);
    }
    public Donor getDonorById(Long id)
    {
        return repo.findById(id).orElse(null);
    }

    public boolean deleteDonor(Long id) 
    {
        if (repo.existsById(id)) 
        {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public Donor updateDonor(Long id, Donor updated) 
    {
        Optional<Donor> optional = repo.findById(id);

        if (optional.isPresent()) 
        {
            Donor donor = optional.get();
            donor.setName(updated.getName());
            donor.setBloodGroup(updated.getBloodGroup());
            donor.setLocation(updated.getLocation());
            donor.setAvailable(updated.isAvailable());

            return repo.save(donor);
        }
        return null;
    }
    
}