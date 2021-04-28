package Lesson_1.prodlike.impl;

import Lesson_1.prodlike.model.PublicationService;
import Lesson_1.prodlike.model.Publication;

/**
 * Получение публиукации из базы
 */
public class DbPublicationService implements PublicationService {
    @Override
    public Publication getHotPublication() {
        return new Publication();
    }
}
