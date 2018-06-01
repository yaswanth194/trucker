package egen.project.service;

import egen.project.Repository.ReadingRepository;
import egen.project.entity.Reading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReadingServiceImpl implements ReadingService {
    @Autowired
    ReadingRepository readingRepository;
    @Transactional
    public void update(Reading read) {
        readingRepository.save(read);

    }
}
