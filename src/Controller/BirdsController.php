<?php
/**
 * Created by PhpStorm.
 * User: foers
 * Date: 15-12-17
 * Time: 00:34
 */

namespace App\Controller;

use App\Model\Entity\User;
use Cake\Event\Event;
use Cake\ORM\TableRegistry;
use Cake\Datasource\ConnectionManager;

class BirdsController extends AppController
{
    public function initilize() {
        parent::initialize();
    }

    public function index() {
        $this->set('birds', parent::callRest('birds'));
        $this->viewBuilder()->setLayout('');
    }
}