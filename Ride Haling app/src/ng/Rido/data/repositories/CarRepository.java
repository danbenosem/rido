package ng.Rido.data.repositories;

import ng.Rido.data.models.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car, String> {
}