[NOTICE]FOR Korean,
	�� ���������� ���� ���� �ּ��� ���� ������ ���� �״�� �ξ����ϴ�. 
	������ ���� �κп� �ѱ� ��Ʈ�� ������ ��쿡, �ؽ�Ʈ���� �ϱ׷����� ������ 
	�����ϱ⿡ ������ ������ ���� �ּ��� ��� �ѹ���׽��ϴ�. 
	���Ŀ� �ѱ� ��Ʈ�� �µ��� ������ �������ؾ��� �κ��̴� ���عٶ��ϴ�.
	�׷� ���̹�����Ʈ�� ��ſ� �ð��� �����ñ� �ٶ��ϴ�. 
	
	������ ������(jdkim528@korea.com)
	Blog : http://blog.naver.com/jdkim528/

[Down/Config/Build]
	cvs Ŭ���̾�Ʈ�� ���� �ִٸ�, 
	1)���� ����	: pserve/extssh �� �ϳ��� �����մϴ�
	2)������̸�	: anonymous
	3)ȣ��Ʈ		: cvs.sourceforge.net
	4)��Ʈ		: �⺻��
	5)����Ұ��	: /cvsroot/hibernate
    6)���		: Hibernate3/doc/reference
	���� ���� ���� ������ �Է� �Ͻ� �� REFERENCE ��ü�� ���������ŵ� ������,
	�ѱ� �������� �ʿ��Ͻôٸ� ������ ���� �ϼŵ� �˴ϴ�.
	[��]. ���� ��� �ޱ�
	������ 6)����� Hibernate3/doc/reference/support�� �����Ͻð� 
	���� ��ǻ���� ���丮 [���� ���]/reference/ �Ͽ� �޽��ϴ�
	[��]. �ѱۺ� ��� �ޱ�
	������ 6)����� Hibernate3/doc/reference/ko�� �����ϰ� 
	���� ��ǻ���� ���丮 [���� ���]/reference/ �Ͽ� �޽��ϴ�.
	[��]. ���� ���� �ޱ�
	�׷� ���� /doc/reference/build.xml ������ ���� ���� ���� 
	�Ʒ� ���� ���� �ѱ� ������ ���� �κе��� �ּ�ó���մϴ�. 
	[��]. �����ϱ�
	�׷� ����  [���� ���]/reference/ ���� ant all.doc�� �����Ͻø� �˴ϴ�.
	���� �ð��� 2�� ���� �ҿ�˴ϴ�.
	[��]. ���� ����
	���丮 [���� ���]/reference/build/ko/ ���丮�� ����� ������ ���ñ� �ٶ��ϴ�.
	�׷� ���̹�����Ʈ�� �Բ� ��ſ� �ð��� ��������.
	
	[��]
	    <target name="all.doc"
            depends="clean"
            description="Compile documentation for all languages and all formats.">

        <!-- TRANSLATOR: Duplicate this line for your language -->
        <!--antcall target="lang.all"><param name="lang" value="en"/></antcall-->
        <!--antcall target="lang.all"><param name="lang" value="zh-cn"/></antcall-->
        <!--antcall target="lang.all"><param name="lang" value="es"/></antcall-->
    	<antcall target="lang.all"><param name="lang" value="ko"/></antcall>

    </target>
    <target name="all.revdiff"
            description="Generates a diff report for all translated versions.">

        <!-- TRANSLATOR: Duplicate this line for your language -->
        <!--antcall target="lang.revdiff"><param name="lang" value="zh-cn"/></antcall-->
        <!--antcall target="lang.revdiff"><param name="lang" value="es"/></antcall-->
    	<antcall target="lang.revdiff"><param name="lang" value="ko"/></antcall>

    </target>
