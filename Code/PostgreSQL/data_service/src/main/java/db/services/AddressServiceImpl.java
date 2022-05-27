package db.services;

import db.dto.AddressDTO;
import db.entity.Address;
import db.interfaces.AddressService;
import db.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepo addressRepo;

    @Override
    public AddressDTO getRestaurantCoordinatesById(int id) {
        Address address = addressRepo.findById(id).get();
        return new AddressDTO(address.getBuildingIdentifier(), address.getLocalIdentifier(), address.getStreet(), address.getZipcode(), address.getX(), address.getY());
    }
}
