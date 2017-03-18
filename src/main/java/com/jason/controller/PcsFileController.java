package com.jason.controller;

import com.jason.constants.Status;
import com.jason.model.PcsFileList;
import com.jason.model.communication.HandleResult;
import com.jason.service.PcsFileService;
import com.jason.util.PagingUtil;
import okhttp3.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by jason on 2017/2/21.
 */

@Controller
@RequestMapping(value = "/file",produces = {"application/json;charset=UTF-8"})
public class PcsFileController extends BaseController{
    @Resource
    private PcsFileService pcsFileService;
    private final String BASE_PATH = propertiesUtil.getProperty("pcb_base_path");

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView listFile(@RequestParam(name = "path",defaultValue = "")String path,@RequestParam(name = "page",defaultValue = "0") int page){
        ModelAndView modelAndView = new ModelAndView("list_file");
        if(path.equals("")){
            path = BASE_PATH + path;
        }
        HandleResult<PcsFileList> handleResult = pcsFileService.getDirFiles(path,"time","asc", PagingUtil.getLimit(page));
        if(handleResult.getStatus() == Status.SUCCESS){
            modelAndView.addObject(handleResult.getResult());
            return modelAndView;
        }else {
            return errorView;
        }
    }

    /**
     *
     * @param path
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/download",method = RequestMethod.GET)
    public ResponseEntity<byte[]> dowloadFile(@RequestParam(required = true)String path) throws IOException {
        String fileName = path.substring(path.lastIndexOf("/")+1);
        HandleResult<Response> handleResult = pcsFileService.downloadFile(path);
        Response response = handleResult.getResult();
        int status = response.code();
        if(status == 200){
            byte[] body = response.body().bytes();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment;filename="+fileName);
            if (handleResult.getStatus() == Status.SUCCESS){
                ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(body,headers, HttpStatus.OK);
                return responseEntity;
            }
        }
        return new ResponseEntity<byte[]>(HttpStatus.SERVICE_UNAVAILABLE);
    }

}
