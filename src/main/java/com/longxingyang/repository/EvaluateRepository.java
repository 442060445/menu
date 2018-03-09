package com.longxingyang.repository;

import com.longxingyang.dataobject.Evaluate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by a4420 on 18/01/23.
 */
public interface EvaluateRepository extends JpaRepository <Evaluate, String>{

    Page<Evaluate> findByUserId(String userId, Pageable pageable);

}
