package Lesson_1.prodlike.impl;

import Lesson_1.prodlike.model.Publication;
import Lesson_1.prodlike.model.PublicationService;

public class CachedPublicationService implements PublicationService {

    private final DbPublicationService dbPublicationService;
    private Publication publication;

    public CachedPublicationService(DbPublicationService dbPublicationService) {
        this.dbPublicationService = dbPublicationService;
    }

    @Override
    public Publication getHotPublication() {
        //если нету - иди в базу
        if (publication == null) {
            publication = dbPublicationService.getHotPublication();
        }
        return publication;
    }
}