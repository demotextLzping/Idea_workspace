package com.lzp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzp.entity.AddressBook;
import com.lzp.mapper.AddressBokMapper;
import com.lzp.service.AddressBookService;
import org.springframework.stereotype.Service;

/**
 * @author: LZPing
 * @date: 2022-12-09 11:10
 * @Description
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBokMapper, AddressBook> implements AddressBookService {

}
