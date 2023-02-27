package ori.wish.spring.demorepository.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ori.wish.spring.demorepository.model.District;

import java.util.Optional;

interface DistrictRepository extends CrudRepository<District, String> {}

@RestController
@RequestMapping("districts")
class RestfulController {
    private final DistrictRepository districtRepository;

    RestfulController(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    @GetMapping
    Iterable<District> getDistricts() {
        return districtRepository.findAll();
    }

    @GetMapping("/{postCode}")
    Optional<District> getDistrict(@PathVariable String postCode) {
        return districtRepository.findById(postCode);
    }

    @PostMapping
    ResponseEntity<District> createDistrict(@RequestBody District district) {
        var result = districtRepository.findById(district.getPostCode());
        if (result.isEmpty()) {
            return new ResponseEntity<>(districtRepository.save(district), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        }
    }

    @PutMapping
    ResponseEntity<District> upsertDistrict(@RequestBody District district) {
        var code = (districtRepository.existsById(district.getPostCode())) ? HttpStatus.OK : HttpStatus.CREATED;
        return new ResponseEntity<>(districtRepository.save(district), code);
    }

    @DeleteMapping("/{postCode}")
    ResponseEntity<District> deleteDistrict(@PathVariable String postCode) {
        districtRepository.deleteById(postCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
