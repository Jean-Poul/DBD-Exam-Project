package db.interfaces;

import db.dto.AddressDTO;


public interface AddressService {
    AddressDTO getRestaurantCoordinatesById(int id);
}
