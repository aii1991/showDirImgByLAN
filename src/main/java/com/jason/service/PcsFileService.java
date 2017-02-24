package com.jason.service;

import com.jason.model.communication.HandleResult;

import java.io.File;

/**
 * Created by jason on 2017/2/20.
 */
public interface PcsFileService {
    /**
     * �ϴ��ļ�
     * @param path pcs·��
     * @param file �ϴ����ļ�
     * @param ondup overwrite ����ͬ��,newcopy �����ļ���������������������������Ϊ���ļ���_����.��׺
     * @return
     */
    HandleResult uploadFile(String path,File file,String ondup);

    /**
     * ����Ŀ¼
     * @param path pcs·��
     * @return
     */
    HandleResult createDir(String path);

    /**
     * ��ȡ�����ļ���Ŀ¼��Ԫ��Ϣ��
     * @param path pcs·��
     * @return
     */
    HandleResult getFsInfo(String path);

    /**
     * ������ȡ�ļ�/Ŀ¼��Ԫ��Ϣ
     * @param param JSON�ַ�����{"list":[{"path":"\/apps\/album\/a\/b\/c"},{"path":"\/apps\/album\/a\/b\/d"}]}
     * @return
     */
    HandleResult getFsInfos(String param);

    /**
     *��ȡĿ¼�µ��ļ��б�
     * @param path pcs·��
     * @param by �����ֶΣ�ȱʡ�����ļ���������time���޸�ʱ�䣩,name���ļ�����,size����С��ע��Ŀ¼�޴�С��

     * @param order ��asc����desc����ȱʡ���ý�������
     * @param limit ������Ŀ���ƣ�������ʽΪ��n1-n2��
     * @return
     */
    HandleResult getDirFiles(String path,String by,String order,String limit);

    /**
     * �ƶ������ļ�/Ŀ¼
     * @param from Դ�ļ���ַ�������ļ�������
     * @param to Ŀ���ļ���ַ�������ļ�������
     * @return
     */
    HandleResult moveFs(String from,String to);

    /**
     * ɾ�������ļ�/Ŀ¼
     * @param path pcs·��
     * @return
     */
    HandleResult delFs(String path);

    /**
     * ����ɾ���ļ�/Ŀ¼
     * @param param ��Ҫɾ�����ļ�����Ŀ¼·�����磺{"list":[{"path":"\/apps\/album\/a\/b\/c"},{"path":"\/apps\/album\/a\/b\/d"}]}
     * @return
     */
    HandleResult delFsList(String param);

    /**
     * ���ļ��������ļ�����֧�ֲ���Ŀ¼����
     * @param path ��Ҫ������Ŀ¼��
     * @param wd �ؼ��ʡ�
     * @param re �Ƿ�ݹ顣
     * @return
     */
    HandleResult searchFile(String path,String wd,String re);

    /**
     * ��ȡ����ͼ
     * @param path
     * @param quality
     * @param height
     * @param width
     * @return
     */
    HandleResult getThumbnail(String path,int quality,int height,int width);

    HandleResult downloadFile(String path);
}
