package com.project.booktime.services;

import com.project.booktime.exception.AuthorNotFoundException;
import com.project.booktime.model.dto.AuthorDTO;
import com.project.booktime.model.entity.Author;
import com.project.booktime.model.helper.AuthorHelper;
import com.project.booktime.repository.IAuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class AuthorService
{
    private final IAuthorRepository repository;

    public AuthorService(IAuthorRepository repository) {
        this.repository = repository;
    }

    public List<AuthorDTO> findAll()
    {
        List<Author> authorList = repository.findAll();

        return AuthorHelper.convertAll(authorList);
    }

    public AuthorDTO findById(String id)
    {
        Optional<Author> author = repository.findById(id);

        if (author.isEmpty()) throw new AuthorNotFoundException();

        return AuthorHelper.convert(author.get());
    }

    public List<AuthorDTO> findAuthorsByBookId(String bookId) {
        List<Author> authorList = repository.findAuthorsByBookId(bookId);

        return AuthorHelper.convertAll(authorList);
    }
  
    public AuthorDTO findByName(String name)
    {
        Author author = repository.findByName(name);

        if (author == null) throw new AuthorNotFoundException();

        return AuthorHelper.convert(author);
    }

    public Boolean findBooleanByName(String name)
    {
        Author author = repository.findByName(name);

        if (author != null)
            return true;
        else
            return false;
    }

    public AuthorDTO add(Author author)
    {
        Author createdAuthor = repository.insert(author);

        return AuthorHelper.convert(createdAuthor);
    }

    public AuthorDTO update (String id, Author author)
    {
        Optional<Author> optionalAuthor = repository.findById(id);

        if (optionalAuthor.isEmpty()) throw new AuthorNotFoundException();

        Author updatedAuthor = repository.save(author);

        return AuthorHelper.convert(updatedAuthor);
    }

    public void delete (String id)
    {
        Optional<Author> optionalAuthor = repository.findById(id);

        if (optionalAuthor.isEmpty()) throw new AuthorNotFoundException();

        repository.delete(optionalAuthor.get());
    }
}
