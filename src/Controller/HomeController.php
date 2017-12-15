<?php
/**
 * Created by PhpStorm.
 * User: foers
 * Date: 11-12-17
 * Time: 12:41
 */

namespace App\Controller;

use App\Controller\AppController;
use Cake\Event\Event;
use Cake\ORM\TableRegistry;
use Cake\Datasource\ConnectionManager;
use Cake\Http\Client;

class HomeController extends AppController
{
    public function initialize()
    {
        parent::initialize();
    }

    public function index() {
        $sessions = parent::callRest('sessions');
        $stats = $this->getStats();
        $birds = parent::callRest('Birds');
        if(isset($stats))
            $this->set('stats', $stats);
        $this->set('Birds', $birds);
        $this->set('sessions', $sessions);
        $this->viewBuilder()->setLayout('base');
    }

    public function isAuthorized($user) {
        return true;
    }

    private function getStats() {
        $result = [];

        $result['users'] = parent::callRest('stats/users');
        $result['obs'] = parent::callRest('stats/observations');
        $result['sessions'] = parent::callRest('stats/sessions');
        $result['Birds'] = parent::callRest('stats/Birds');
        return $result;
    }
}