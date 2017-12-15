<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\CountObservationsSessionsUserTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\CountObservationsSessionsUserTable Test Case
 */
class CountObservationsSessionsUserTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\CountObservationsSessionsUserTable
     */
    public $CountObservationsSessionsUser;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.count_observations_sessions_user'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('CountObservationsSessionsUser') ? [] : ['className' => CountObservationsSessionsUserTable::class];
        $this->CountObservationsSessionsUser = TableRegistry::get('CountObservationsSessionsUser', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->CountObservationsSessionsUser);

        parent::tearDown();
    }

    /**
     * Test initialize method
     *
     * @return void
     */
    public function testInitialize()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }

    /**
     * Test validationDefault method
     *
     * @return void
     */
    public function testValidationDefault()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }
}
