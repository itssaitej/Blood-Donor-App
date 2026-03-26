package com.blood.donorApp.service;

	import com.blood.donorApp.dto.RegisterRequest;
	import com.blood.donorApp.model.User;
	import com.blood.donorApp.model.Donor;
	import com.blood.donorApp.repository.UserRepository;
	import com.blood.donorApp.repository.DonorRepository;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.crypto.password.PasswordEncoder;
	import org.springframework.stereotype.Service;

	@Service
	public class AuthService 
	{

	    @Autowired
	    private UserRepository userRepo;

	    @Autowired
	    private DonorRepository donorRepo;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    public String register(RegisterRequest request) 
	    {

	        // 1️⃣ Create User
	        User user = new User();
	        user.setUsername(request.getUsername());
	        if (userRepo.findByUsername(request.getUsername()) != null) 
	        {
	            return "Username already exists";
	        }
	        user.setPassword(passwordEncoder.encode(request.getPassword()));
	        userRepo.save(user);

	        // 2️⃣ Create Donor
	        Donor donor = new Donor();
	        donor.setName(request.getName());
	        donor.setBloodGroup(request.getBloodGroup());
	        donor.setCity(request.getCity());
	        donor.setArea(request.getArea());
	        donor.setLocation(request.getLocation());
	        donor.setAvailable(request.isAvailable());

	        donor.setUser(user);
	        donorRepo.save(donor);

	        return "User + Donor registered successfully";
	    }
     }
