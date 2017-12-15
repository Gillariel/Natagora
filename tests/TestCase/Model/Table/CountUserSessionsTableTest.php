<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\CountUserSessionsTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\CountUserSessionsTable Test Case
 */
class CountUserSessionsTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\CountUserSessionsTable
     */
    public $CountUserSessions;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.count_user_sessions'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('CountUserSessions') ? [] : ['className' => CountUserSessionsTable::class];
        $this->CountUserSessions = TableRegistry::get('CountUserSessions', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->CountUserSessions);

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
