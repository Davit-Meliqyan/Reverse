package am.reverse.mappers;

import am.reverse.dto.AddressDto;
import am.reverse.entities.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address toAddress(AddressDto addressDto) {
        Address address = new Address();

        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCountry());

        return address;
    }

    public AddressDto toAddressDto(Address address) {

        AddressDto addressDto = new AddressDto();

        addressDto.setCountry(address.getCountry());
        addressDto.setCity(addressDto.getCity());

        return addressDto;
    }
}
