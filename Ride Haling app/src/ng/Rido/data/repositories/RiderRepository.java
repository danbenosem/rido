package ng.Rido.data.repositories;

import ng.Rido.data.models.Rider;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RiderRepository extends MongoRepository<Rider, String> {
}