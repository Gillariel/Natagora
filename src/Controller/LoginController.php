<?php
/**
 * Created by PhpStorm.
 * User: foers
 * Date: 11-12-17
 * Time: 13:59
 */

namespace App\Controller;

use App\Controller\AppController;
use App\Model\Entity\User;
use Cake\Event\Event;
use Cake\ORM\TableRegistry;
use Cake\Datasource\ConnectionManager;
use Cake\Http\Client;

class LoginController extends AppController
{
    public function initialize()
    {
        parent::initialize();
    }

    public function index() {

        $session = $this->request->session();

        $res = $this->request->getQuery('callback');
        $username = $this->request->getQuery('username');
        if(isset($res) && $res == 1 && isset($username)){
            $session->write('Username', $username);
            $this->redirect('/home');
        }
        $this->viewBuilder()->setLayout('');
    }

    public function signin() {
        $fb = $this->request->getQuery('fb');
        $name = $this->request->getQuery('name');
        $forname = $this->request->getQuery('forname');
        $mail = $this->request->getQuery('mail');

        if(isset($fb) && isset($name) && isset($forname) && isset($mail)){
            $this->set('name', $name);
            $this->set('forname', $forname);
            $this->set('mail', $mail);
            $this->set('fb', $fb);
        }

        $this->viewBuilder()->setLayout('');
    }

    public function logout() {
        $session = $this->request->session();
        $session->delete('Username');
        $this->redirect('/home');
    }
}